package by.ustsinovich.kmeansclusteranalysis.utils;

import by.ustsinovich.kmeansclusteranalysis.model.Cluster;
import by.ustsinovich.kmeansclusteranalysis.model.Point;
import by.ustsinovich.kmeansclusteranalysis.random.RandomListItemPicker;

import java.util.ArrayList;
import java.util.List;

public class ClustersUtils {
    public static List<Cluster> initializeClustersListByPointsList(int size, List<Point> points) {
        if (size > points.size()) {
            throw new IllegalArgumentException("Clusters list size must be less or equal to points list.");
        }

        List<Cluster> clusters = new ArrayList<>(size);
        RandomListItemPicker<Point> picker = new RandomListItemPicker<>(points);

        for (int i = 0; i < size; i++) {
            Point centroid = picker.nextItem();
            Cluster cluster = new Cluster(centroid);

            clusters.add(cluster);
        }

        return clusters;
    }
}
