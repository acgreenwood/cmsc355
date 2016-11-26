package sean.itr1;

import java.util.ArrayList;

public class MemoryDatabase {

    private static ArrayList<Series> archive = new ArrayList<>();

    public static ArrayList<Series> getArchive() {
        return archive;
    }

    static {
        archive.add(new Series(0, "Stranger Things", "Television", "Mystery"));
        archive.add(new Series(1, "Bob's Burgers", "Television", "Comedy"));
        archive.add(new Series(2, "Harry Potter", "Book", "Fantasy"));
        archive.add(new Series(3, "Silence of the Lambs", "Movie", "Thriller"));
        archive.add(new Series(4, "Attack On Titan", "Anime", "Action"));
        archive.add(new Series(5, "The Office", "Television", "Comedy"));
        archive.add(new Series(6, "The New Boston's Android Tutorials", "Internet", "Academic"));
        archive.add(new Series(7, "SpongeBob SquarePants", "Anime", "Romance"));
        archive.add(new Series(8, "Cory in the House", "Anime", "Comedy"));

        archive.get(0).setImdb("http://www.imdb.com/title/tt4574334/");
        archive.get(1).setImdb("http://www.imdb.com/title/tt1561755/");
        archive.get(3).setImdb("http://www.imdb.com/title/tt0102926/");
        archive.get(4).setImdb("http://www.imdb.com/title/tt2560140/");
        archive.get(5).setImdb("http://www.imdb.com/title/tt0386676/");
        archive.get(7).setImdb("http://www.imdb.com/title/tt0206512/");
        archive.get(8).setImdb("http://www.imdb.com/title/tt0805815/");

        archive.get(0).setWiki("https://en.wikipedia.org/wiki/Stranger_Things_(TV_series)");
        archive.get(1).setWiki("https://en.wikipedia.org/wiki/Bob's_Burgers");
        archive.get(2).setWiki("https://en.wikipedia.org/wiki/Harry_Potter");
        archive.get(3).setWiki("https://en.wikipedia.org/wiki/The_Silence_of_the_Lambs_(film)");
        archive.get(4).setWiki("https://en.wikipedia.org/wiki/Attack_on_Titan");
        archive.get(5).setWiki("https://en.wikipedia.org/wiki/The_Office_(U.S._TV_series)");
        archive.get(7).setWiki("https://en.wikipedia.org/wiki/SpongeBob_SquarePants");
        archive.get(8).setWiki("https://en.wikipedia.org/wiki/Cory_in_the_House");


    }

    /**
     * Returns series, given an integer id
     * @param id integer id
     * @return series with id, or null if not found
     */
    public static Series getSeriesById(int id) {
        for (Series element: archive) {
            if (element.getId() == id) {
                return element;
            }
        }
        return null;
    }

    /**
     * returns arraylist of series, with most relavent searches last
     */
    public static ArrayList<Series> searchByTerms(String terms) {
        ArrayList<Series> findings = new ArrayList<>();

        //separate each search term into termTokens
        String[] termTokens = terms.split(" ");

        if (terms.isEmpty()) {
            for (int i = 0; i < archive.size(); i++) {
                findings.add(getSeriesById(i));
            }
            return findings;
        }

        //search for titles containing at least one search term
        for (Series element: archive) {
            for (int i = 0; i < termTokens.length; i++) {
                if (element.getTitle().toLowerCase().contains(termTokens[i].toLowerCase())) {
                    findings.add(element);
                    break;
                }
            }
        }

        //search for titles with all the terms
        //this might get slow for long lists
        for (int j = 2; j <= termTokens.length; j++) {
            for (int k = 0; k < findings.size(); k++) {
                int termsFound = 0;
                for (int i = 0; i < termTokens.length; i++) {
                    if (findings.get(k).getTitle().toLowerCase()
                            .contains(termTokens[i].toLowerCase())) {
                        termsFound++;
                    }
                    if (termsFound >= j) {
                        findings.add(findings.remove(k));
                    }
                }
            }
        }

        //search for titles with all terms in order together
        for (int k = 0; k < findings.size(); k++) {
            if ( findings.get(k).getTitle().toLowerCase().contains(terms.toLowerCase())) {
                findings.add(findings.remove(k));
            }
        }
        //return the list of findings, which has most relevant listings at the end
        return findings;
    }

    public static void addSeries(Series seriesToAdd) {
        seriesToAdd.setId(archive.size());
        archive.add(seriesToAdd);
    }

    public static int getArchiveSize() {
        return archive.size();
    }
}
