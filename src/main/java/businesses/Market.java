package businesses;

import util.Pair;

import java.util.*;

/**
 * Класс описывающий рынок, как сферу товарообращения
 * @author vadim
 */
public class Market {
    protected int allMass = 0;
    Map<IndustryType, List<Business<?>>> companies = new HashMap<>();

    {
        Arrays.stream(IndustryType.values()).forEach(i -> companies.put(i, new ArrayList<>()));
    }
    public void addBusines(Business<?> business){
        for (Pair<IndustryType, Integer> now: business.getTypes()){
            companies.get(now.getFirst()).add(business);
            allMass += now.getSecond();
        }
    }

    public List<Business<?>> getIndustry(IndustryType type){
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
