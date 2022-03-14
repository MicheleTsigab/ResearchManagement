package io.research.Repository;

import io.research.database.ProposalCall;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProposaCallRepository extends JpaRepository<ProposalCall, Long> {
}
