package Lab_6;

public class Grade {
    public char letter;

    public Grade() {
        this('F');
    }

    public Grade(char letter) {
        this.letter = letter;
    }

    public Grade(Grade other) {
        if (other != null) {
            this.letter = other.letter;
        } else {
            this.letter = 'F';
        }
    }

    public int points() {
        switch (Character.toUpperCase(letter)) {
            case 'A': return 5;
            case 'B': return 4;
            case 'C': return 3;
            case 'D': return 2;
            case 'F': return 1;
            default: return 0;
        }
    }
    public boolean isPassing() {
        char upper = Character.toUpperCase(letter);
        return upper == 'A' || upper == 'B' || upper == 'C';
    }

    @Override
    public String toString() {
        return "Grade{letter='" + letter + "'}";
    }
}