package org.practice.spitter.data;

import org.practice.spitter.Spittle;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SimpleSpittleRepository implements SpittleRepository {

    private List<Spittle> list;

    public SimpleSpittleRepository(List<Spittle> list) {
        this.list = list;
    }

    @Override
    public List<Spittle> findSpittles(long max, int count) {
        List<Spittle> foundList = new ArrayList<>();
        for (Spittle spittle : list)
            if (spittle.getId() <= max && foundList.size() < count)
                foundList.add(spittle);
        return foundList;
    }

    public List<Spittle> getList() {
        return list;
    }
}
