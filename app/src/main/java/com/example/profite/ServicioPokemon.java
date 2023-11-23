package com.example.profite;
import java.util.List;

public class ServicioPokemon {
    private long count;
    private List<Pokemon> results;

    public long getCount() { return count; }
    public void setCount(long value) { this.count = value; }

    public List<Pokemon> getResults() { return results; }
    public void setResults(List<Pokemon> value) { this.results = value; }
}

