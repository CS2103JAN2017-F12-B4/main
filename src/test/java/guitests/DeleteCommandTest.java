package guitests;

import static org.junit.Assert.assertTrue;
import static seedu.bulletjournal.logic.commands.DeleteCommand.MESSAGE_DELETE_PERSON_SUCCESS;

import org.junit.Test;

import seedu.bulletjournal.testutil.TestTask;
import seedu.bulletjournal.testutil.TestUtil;

public class DeleteCommandTest extends TodoListGuiTest {

    @Test
    public void delete() {

        //delete the first in the list
        TestTask[] currentList = td.getTypicalPersons();
        int targetIndex = 1;
        assertDeleteSuccess(targetIndex, currentList);

        //delete the last in the list
        currentList = TestUtil.removePersonFromList(currentList, targetIndex);
        targetIndex = currentList.length;
        assertDeleteSuccess(targetIndex, currentList);

        //delete from the middle of the list
        currentList = TestUtil.removePersonFromList(currentList, targetIndex);
        targetIndex = currentList.length / 2;
        assertDeleteSuccess(targetIndex, currentList);

        //invalid index
        commandBox.runCommand("delete " + currentList.length + 1);
        assertResultMessage("The task index provided is invalid");

        //Flexible delete command
        commandBox.runCommand("del " + currentList.length + 1);
        assertResultMessage("The task index provided is invalid");

        commandBox.runCommand("d " + currentList.length + 1);
        assertResultMessage("The task index provided is invalid");

        commandBox.runCommand("deletes " + currentList.length + 1);
        assertResultMessage("The task index provided is invalid");

        commandBox.runCommand("removes " + currentList.length + 1);
        assertResultMessage("The task index provided is invalid");

        commandBox.runCommand("remove " + currentList.length + 1);
        assertResultMessage("The task index provided is invalid");

        commandBox.runCommand("rm " + currentList.length + 1);
        assertResultMessage("The task index provided is invalid");
    }

    /**
     * Runs the delete command to delete the person at specified index and confirms the result is correct.
     * @param targetIndexOneIndexed e.g. index 1 to delete the first person in the list,
     * @param currentList A copy of the current list of persons (before deletion).
     */
    private void assertDeleteSuccess(int targetIndexOneIndexed, final TestTask[] currentList) {
        TestTask personToDelete = currentList[targetIndexOneIndexed - 1]; // -1 as array uses zero indexing
        TestTask[] expectedRemainder = TestUtil.removePersonFromList(currentList, targetIndexOneIndexed);

        commandBox.runCommand("delete " + targetIndexOneIndexed);

        //confirm the list now contains all previous persons except the deleted person
        assertTrue(personListPanel.isListMatching(expectedRemainder));

        //confirm the result message is correct
        assertResultMessage(String.format(MESSAGE_DELETE_PERSON_SUCCESS, personToDelete));
    }

}
