package lapr.lists;

import lapr.controller.AppPOE;
import lapr.model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class ListTaskTest {

    ListTask lt;
    Task tsk1; // in lt
    Task tsk2; // in lt
    Task tsk3;
    Task tsk4; // equals tsk1
    Organization org;



    @BeforeEach
    void setUp() throws IOException {

        tsk1 = ListTask.newTask("TSK1", "A Test task 1", 10, 10, "TEST");
        tsk2 = ListTask.newTask("TSK2", "A Test task 2", 10, 10, "TEST");
        tsk3 = ListTask.newTask("TSK3", "A Test task 3", 10, 10, "TEST");
        tsk4 = ListTask.newTask("TSK1", "A Test task 3", 10, 10, "TEST");
        AppPOE.restartInstance();
        App app = AppPOE.getInstance().getApp();
        Manager testMan = new Manager("Man Joe", "man@dei.pt", "password");
        Collaborator testCol = new Collaborator("Colab Joe", "colab@dei.pt", "password");
        org = app.getRegistOrganization().newOrganization("DEFAULT","name", testMan, testCol);
        lt = org.getListTask();
        org.getListTask().registerTask(tsk1);
        org.getListTask().registerTask(tsk2);
    }


    @Test
    void newTask() {
        Task expected = tsk1;
        Task result = ListTask.newTask("TSK1", "A Test task 1", 10, 10, "TEST");
        assertEquals(expected, result);
    }


    @Test
    void registTask() {
        assertFalse(lt.registerTask(ListTask.newTask("TSK1", "A Test task 4", 10, 10, "TEST")));
        assertTrue(lt.registerTask(ListTask.newTask("TSK5", "A Test task 5", 10, 10, "TEST")));
        Task tsk4 = ListTask.newTask("TSK3", "A Test task 4", 10, 10, "TEST");
        assertTrue(lt.registerTask(tsk4));
    }

    @Test
    void validatesTask() {
        assertFalse(lt.validatesTask((tsk1)));
        assertTrue(lt.add(tsk1));
        assertFalse(lt.validatesTask(tsk1));
    }

    @Test
    void getUnexecutedTasks() {
        assertEquals(lt.getUnexecutedTasks(),org.getListTask().getUnexecutedTasks());
    }

    @Test
    void getEqualTask() {
        assertNull(lt.getSameTask(tsk3));
        assertSame(tsk1, lt.getSameTask(tsk4));
    }

    @Test
    void getTasks() {
        assertEquals(lt.getTasks(),org.getListTask().getTasks());
    }
}