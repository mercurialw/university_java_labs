import java.util.Stack;

public class RemoteControl {
    private final Stack<Command> commands = new Stack<>();

    public void pressExecute(Command command) {
        command.execute();
        commands.push(command);
    }

    public void pressUndo() {
        if (commands.empty()) {
            System.out.println("Nothing to undo");
            return;
        }
        commands.pop().undo();
    }
}
