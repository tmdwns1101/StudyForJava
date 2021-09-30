package programmers.ranksearch;

import java.util.*;

public class Solution {

    static class Candidate {
        int id;
        String language;
        String job;
        String career;
        String favoriteFood;
        int score;

        public Candidate(int id, String language, String job, String career, String favoriteFood, int score) {
            this.id = id;
            this.language = language;
            this.job = job;
            this.career = career;
            this.favoriteFood = favoriteFood;
            this.score = score;
        }
    }

    public List<Integer> solution(String[] info, String[] queries) {
        List<Integer> answer = new ArrayList<>();

        Map<String, Set<Integer>> languages = new HashMap<>();
        Map<String, Set<Integer>> jobs = new HashMap<>();
        Map<String, Set<Integer>> careers = new HashMap<>();
        Map<String, Set<Integer>> favoriteFoods = new HashMap<>();

        Map<Integer, Candidate> candidates = new HashMap<>();


        for (int i = 0; i < info.length; i++) {
            String myInfo = info[i];

            String[] parse = myInfo.split(" ");
            String language = parse[0];
            String job = parse[1];
            String career = parse[2];
            String favoriteFood = parse[3];
            int score = Integer.parseInt(parse[4]);
            Candidate candidate = new Candidate(i, language, job, career, favoriteFood, score);
            candidates.put(i, candidate);

            Set<Integer> languageSet;
            if (!languages.containsKey(language)) {
                languageSet = new HashSet<>();
            } else {
                languageSet = new HashSet<>(languages.get(language));
            }
            languageSet.add(i);
            languages.put(language, languageSet);

            Set<Integer> jobSet;
            if (!jobs.containsKey(job)) {
                jobSet = new HashSet<>();
            } else {
                jobSet = new HashSet<>(jobs.get(job));
            }
            jobSet.add(i);
            jobs.put(job, jobSet);

            Set<Integer> careerSet;
            if (!careers.containsKey(career)) {
                careerSet = new HashSet<>();
            } else {
                careerSet = new HashSet<>(careers.get(career));
            }
            careerSet.add(i);
            careers.put(career, careerSet);

            Set<Integer> favoriteFoodSet;
            if (!favoriteFoods.containsKey(favoriteFood)) {
                favoriteFoodSet = new HashSet<>();
            } else {
                favoriteFoodSet = new HashSet<>(favoriteFoods.get(favoriteFood));
            }
            favoriteFoodSet.add(i);
            favoriteFoods.put(favoriteFood, favoriteFoodSet);

        }

        List<Integer> sortedCandidate = new ArrayList<>(candidates.keySet());
        sortedCandidate.sort((o1, o2) -> {
           int score1 = candidates.get(o1).score;
           int score2 = candidates.get(o2).score;
           return Integer.compare(score1, score2);
        });


        for (String query : queries) {

            String[] parse = query.split(" and ");
            String language = parse[0];
            String job = parse[1];
            String career = parse[2];
            String favoriteFood = parse[3].split(" ")[0];
            int score = Integer.parseInt(parse[3].split(" ")[1]);

            List<Integer> ids = new ArrayList<>(sortedCandidate);

            //Collection retainAll
            //worst case O(M*N)
            if (languages.containsKey(language)) {
                ids.retainAll(languages.get(language));
            }

            if(jobs.containsKey(job)) {
                ids.retainAll(jobs.get(job));
            }

            if(careers.containsKey(career)) {
                ids.retainAll(careers.get(career));
            }

            if(favoriteFoods.containsKey(favoriteFood)) {
                ids.retainAll(favoriteFoods.get(favoriteFood));
            }

            int count = 0;

            //이부분이 비효율적
            //O(ids * query 개수) 즉, O(mn)
//            for(int id: ids){
//                if(candidates.get(id).score >= score) count++;
//            }

            int left = 0;
            int right = ids.size();
            while(left < right) {
                int mid = (left + right) / 2;
                if(candidates.get(ids.get(mid)).score < score) left = mid + 1;
                else right = mid;
            }

            count = ids.size() - right;
            answer.add(count);
        }
        return answer;
    }

}
