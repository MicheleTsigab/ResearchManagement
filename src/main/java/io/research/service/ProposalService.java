package io.research.service;


import io.research.Repository.EvaluationReportRepository;
import io.research.Repository.FileStorageRepository;
import io.research.Repository.ProposalRepository;
import io.research.Repository.StaffRepository;
import io.research.database.Activity;
import io.research.database.EvaluationReport;
import io.research.database.Proposal;
import io.research.database.Version;
import io.research.model.Milestone;
import io.research.model.PidReviewsBody1;
import io.research.model.Point;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class ProposalService {

    private final ProposalRepository proposalRepository;
    private final StaffRepository staffRepository;
    private final FileStorageRepository fileStorageRepository;
    private final EvaluationReportRepository evaluationReportRepository;

    public ProposalService(ProposalRepository proposalRepository, StaffRepository staffRepository, FileStorageRepository fileStorageRepository, EvaluationReportRepository evaluationReportRepository) {
        this.proposalRepository = proposalRepository;
        this.staffRepository = staffRepository;
        this.fileStorageRepository = fileStorageRepository;
        this.evaluationReportRepository = evaluationReportRepository;
    }

    public Proposal getProposalById(long id){
        Optional<Proposal> proposal = proposalRepository.findById(id);
        Proposal pop = proposal.orElseThrow(()->new RuntimeException("Proposal Not Found"));
        return pop;
    }


    public void addMileStone(long proposalId, Milestone milestone){
        Proposal pop = getProposalById(proposalId);
        io.research.database.Milestone ml = new io.research.database.Milestone(milestone.getName(),milestone.getBudget(),
                milestone.getActivity().stream().map(Activity::new).collect(Collectors.toList()),false,milestone.isRequested());
        pop.getMilestones().add(ml);
        proposalRepository.save(pop);
    }

    public void addAnotherVersionOfThePaper(long proposalId,String title, String abstra, MultipartFile file1, MultipartFile file2){
        Proposal pop = getProposalById(proposalId);

        //stage of the new paper will be set based on the last version of the paper if there is not last vesion then the paper stage will
        //be the starting point which is department
        String stage = "Department";
        if(pop.getVersion().size()>=1){
            stage = pop.getVersion().get(pop.getVersion().size()-1).getStage();
        }
        //for name of each file will be based on the current millisecond to avoid redundancy of file name and over write.
        String name1= System.currentTimeMillis()+"";
        String name2= System.currentTimeMillis()+"";
        //saving each file to the file system
        fileStorageRepository.save(file1,name1);
        fileStorageRepository.save(file2,name2);

        Version version = new Version(title,abstra,name1,name2,stage);
        pop.getVersion().add(version);
        proposalRepository.save(pop);
    }

    //check if the given user is an evaluator or not.
    public Optional<EvaluationReport> isEvaluator(long pid,long uid){
        Optional<EvaluationReport> eval = evaluationReportRepository.findEvaluationReportByProposalId(pid);
        EvaluationReport evalRepo = eval.orElseThrow(()->new RuntimeException("The paper doesn't have any evaluation report"));
        boolean value = evalRepo.getEvaluators().stream()
                .anyMatch(e->e.getId()==pid);
        if(value){
            return eval;
        }
        else{
        throw new RuntimeException("Sorry you are not an Evaluator for this paper");
        }
        
    }

    public void addListOfPoint(Integer uid,Integer pid, List<Point> body) {

        isEvaluator(pid,uid).ifPresent(evalRepo->{
            Set<io.research.database.Point> points = body.stream()
                    .map(e->new io.research.database.Point(e.getWeight(),e.getName()))
                    .collect(Collectors.toSet());
            evalRepo.getPoints().addAll(points);
            evaluationReportRepository.save(evalRepo);
        });

    }

    public void addReviewFile(Integer uid, Integer pid, MultipartFile file) {
        isEvaluator(pid,uid).ifPresent(e->{
            String name = System.currentTimeMillis()+""; //name of the paper
            fileStorageRepository.save(file,name);
            List<String> paperList = new ArrayList<>(Arrays.asList(e.getPapers()));
            paperList.add(name);
            String[] papers = paperList.toArray(new String[paperList.size()]); 
            e.setPapers(papers);
            evaluationReportRepository.save(e);
        });
    }

    public void addReviewToPaper(Integer uid, Integer pid, List<PidReviewsBody1> body) {
    }
}
