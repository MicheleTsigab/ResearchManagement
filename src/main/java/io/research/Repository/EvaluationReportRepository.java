package io.research.Repository;

import io.research.database.EvaluationReport;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EvaluationReportRepository extends JpaRepository<EvaluationReport,Long> {
    Optional<EvaluationReport> findEvaluationReportByProposalId(Long pid);
}
