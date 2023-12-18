package Controll.CommandProcessPattern;

abstract class CommandProcessor {
    // Metoda șablon
    public final void processCommand() {
        validateCommand();
        executeCommand();
        logCommand();
    }

    protected abstract void validateCommand();
    protected abstract void executeCommand();
    protected abstract void logCommand();
}
