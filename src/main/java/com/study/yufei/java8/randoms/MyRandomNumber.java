package com.study.yufei.java8.randoms;

import org.apache.commons.lang3.RandomUtils;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author yufei.wang
 * @date 2020/12/11 11:58
 */
public class MyRandomNumber {


    public static class IncrementRange {

        private Integer min;

        private Integer max;

        private Double chance;

        private Double percentScopeMin;

        private Double percentScopeMax;


        public Integer getMin() {
            return min;
        }

        public void setMin(Integer min) {
            this.min = min;
        }

        public Integer getMax() {
            return max;
        }

        public void setMax(Integer max) {
            this.max = max;
        }

        public Double getChance() {
            return chance;
        }

        public void setChance(Double chance) {
            this.chance = chance;
        }

        public Double getPercentScopeMin() {
            return percentScopeMin;
        }

        public void setPercentScopeMin(Double percentScopeMin) {
            this.percentScopeMin = percentScopeMin;
        }

        public Double getPercentScopeMax() {
            return percentScopeMax;
        }

        public void setPercentScopeMax(Double percentScopeMax) {
            this.percentScopeMax = percentScopeMax;
        }

        private IncrementRange() {
        }

        public IncrementRange(Integer min, Integer max, Double chance) {
            this.min = min;
            this.max = max;
            this.chance = chance;
        }
    }

    private static int produceRandom(List<IncrementRange> incrementRanges) {

        final double[] scopeMax = {0};
        List<IncrementRange> ranges = incrementRanges.stream().map(incrementRange -> {
            IncrementRange range = new IncrementRange();
            range.setMin(incrementRange.getMin());
            range.setMax(incrementRange.getMax());
            range.setPercentScopeMin(scopeMax[0] + 1);
            range.setPercentScopeMax(range.getPercentScopeMin() + (incrementRange.getChance() - 1));
            scopeMax[0] = range.getPercentScopeMax();
            return range;
        }).collect(Collectors.toList());

        double min = ranges.get(0).getPercentScopeMin();
        double max = ranges.get(ranges.size() - 1).getPercentScopeMax() + 1;
        double randomDouble = RandomUtils.nextDouble(min, max);
        int randomNum = ranges.get(0).getMin();
        for (IncrementRange range : ranges) {
            if (range.getPercentScopeMin() <= randomDouble && randomDouble <= range.getPercentScopeMax()) {
                randomNum = RandomUtils.nextInt(range.getMin(), range.getMax());
                break;
            }
        }

        return randomNum;
    }

    public static void main(String[] args) {

        List<IncrementRange> incrementRanges = new ArrayList<>();
        IncrementRange incrementRange1 = new IncrementRange(0, 49, 50.00);
        IncrementRange incrementRange2 = new IncrementRange(50, 99, 35.00);
        IncrementRange incrementRange3 = new IncrementRange(100, 149, 10.00);
        IncrementRange incrementRange4 = new IncrementRange(150, 200, 5.00);

        incrementRanges.add(incrementRange1);
        incrementRanges.add(incrementRange2);
        incrementRanges.add(incrementRange3);
        incrementRanges.add(incrementRange4);

        List<Integer> randomNums = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            randomNums.add(produceRandom(incrementRanges));
        }

        randomNums.sort(Comparator.comparing(Integer::intValue));
        randomNums.forEach(System.out::println);
    }
}
