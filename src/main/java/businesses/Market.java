package businesses;

import util.Pair;

import java.util.*;

/**
 * Класс описывающий рынок, как сферу товарообращения
 * @author vadim
 */
public class Market {
    protected int allMass = 0;
    Map<IndustryType, List<Pair<Business<?>, Integer> >> companies = new HashMap<>();

    {
        Arrays.stream(IndustryType.values()).forEach(i -> companies.put(i, new ArrayList<>()));
    }
    public void addBusiness(Business<?> business){
        for (Pair<IndustryType, Integer> now: business.getTypes()){
            companies.get(now.getFirst()).add(new Pair<>(business, now.getSecond()));
            allMass += now.getSecond();
        }
    }

    public int getAllMass(){
        return allMass;
    }

    public List<Pair<Business<?>, Integer>> getIndustry(IndustryType type){
        return companies.get(type);
    }

    @Override
    public String toString() {
        return "Market{" +
                "allMass=" + allMass +
                ", companies=" + companies +
                '}';
    }
}
