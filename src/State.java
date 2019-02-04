public class State {
    private String name;
    private String capital;

    public State(String name, String capital) {
        this.name = name;
        this.capital = capital;
    }

    public String getName() {
        return this.name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getCapital() {
        return this.capital;
    }

    public void setCapital(final String capital) {
        this.capital = capital;
    }
}
