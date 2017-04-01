package seedu.bulletjournal.logic.commands;

import seedu.bulletjournal.logic.commands.exceptions.CommandException;

/**
 * Represents an incorrect command. Upon execution, throws a CommandException with feedback to the user.
 */
public class IncorrectCommand extends Command {

    public final String feedbackToUser;

    public IncorrectCommand(String feedbackToUser) {
        this.feedbackToUser = feedbackToUser;
    }

    @Override
    public CommandResult execute() throws CommandException {
        throw new CommandException(feedbackToUser);
    }

    @Override
    public CommandResult undo() throws CommandException {
        // TODO Auto-generated method stub
        return null;
    }

}

