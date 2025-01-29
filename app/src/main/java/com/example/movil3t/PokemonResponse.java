package com.example.movil3t;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class PokemonResponse {

    @SerializedName("results")
    private List<PokemonName> results;

    public List<PokemonName> getResults() {
        return results;
    }

    public void setResults(List<PokemonName> results) {
        this.results = results;
    }

    // Clase interna para los nombres de los Pokémon
    public static class PokemonName {
        @SerializedName("name")
        private String name;

        @SerializedName("url")
        private String url;

        public PokemonName(String name, String url) {
            this.name = name;
            this.url = url;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}
