package sem.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import sem.model.Project;
import sem.model.User;
import sem.model.UsersProject;
import sem.repository.ProjectRepository;
import sem.repository.UserRepository;
import sem.repository.UsersProjectRepository;

import java.util.List;
import java.util.Optional;

import static org.mockito.BDDMockito.given;

import static org.mockito.Mockito.verify;

@SpringBootTest
class UserProjectServiceTest {
    @MockBean
    private UsersProjectRepository usersProjectRepository;
    @MockBean
    private UserRepository userRepository;
    @MockBean
    private ProjectRepository projectRepository;
    @Autowired
    private UserProjectService userProjectService;

    @Test
    void getUsersByProjectId() {
        User user1 = new User();
        user1.setUserName("user1");
        user1.setId(1l);


        User user2 = new User();
        user2.setUserName("user2");
        user2.setId(2l);
        List<Long> usersId = List.of(user1.getId(), user2.getId());
        given(usersProjectRepository.findAllUserIdByProjectId(1l)).willReturn(usersId);
        List<User>users = List.of(user1, user2);
        given(userRepository.findUserByIdIn(usersId)).willReturn(users);

        userProjectService.getUsersByProjectId(1l);

        verify(usersProjectRepository).findAllUserIdByProjectId(1l);
        verify(userRepository).findUserByIdIn(usersId);
    }

    @Test
    void getProjectsByUserId() {
        Project project = new Project();
        project.setId(1l);
        project.setName("project1");

        Project project1 = new Project();
        project1.setId(2l);
        project1.setName("project2");

        List<Long> projectId = List.of(project.getId(), project1.getId());
        given(usersProjectRepository.findAllProjectIdByUserId(1l)).willReturn(projectId);
        List<Project>projects = List.of(project, project1);
        given(projectRepository.findProjectByIdIn(projectId)).willReturn(projects);

        userProjectService.getProjectsByUserId(1l);

        verify(usersProjectRepository).findAllProjectIdByUserId(1l);
        verify(projectRepository).findProjectByIdIn(projectId);
    }


    @Test
    void removeUserFromProject() {
        UsersProject usersProject =  new UsersProject(1l, 1l);
        given(usersProjectRepository.findByUserIdAndProjectId(1l,1l)).willReturn(usersProject);

        userProjectService.removeUserFromProject(1l,1l);

        verify(usersProjectRepository).findByUserIdAndProjectId(1l,1l);
        verify(usersProjectRepository).delete(usersProject);
    }

    @Test
    void isUserAndProjectExist() {
        Project project = new Project();
        project.setId(1l);
        given(userRepository.findById(1l)).willReturn(null);
        given(projectRepository.findById(1l)).willReturn(Optional.of(project));

        userProjectService.isUserAndProjectExist(1l,1l);
        verify(userRepository).findById(1l);

        Assertions.assertEquals( userProjectService.isUserAndProjectExist(1l,1l),false);

        User user =  new User();
        user.setId(1l);
        given(userRepository.findById(1l)).willReturn(Optional.of(user));
        Assertions.assertEquals( userProjectService.isUserAndProjectExist(1l,1l),true);

    }
}
