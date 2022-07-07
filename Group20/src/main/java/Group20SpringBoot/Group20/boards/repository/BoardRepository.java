package Group20SpringBoot.Group20.boards.repository;

import Group20SpringBoot.Group20.boards.entity.WorkspaceModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardRepository extends JpaRepository<WorkspaceModel, Integer> {
}
