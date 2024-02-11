package by.ustsinovich.kmeansclusteranalysis.utils;

import by.ustsinovich.kmeansclusteranalysis.model.Cluster;
import by.ustsinovich.kmeansclusteranalysis.model.Point;

import java.util.List;

import static by.ustsinovich.kmeansclusteranalysis.utils.ClustersUtils.initializeClustersListByPointsList;

public class ClusteringUtils {
    public static List<Cluster> clusterizeByKMeans(int k, List<Point> points) {
        List<Cluster> clusters = initializeClustersListByPointsList(k, points);

        boolean convergence = false;
        while (!convergence) {
            for (Cluster cluster : clusters) {
                cluster.clearPoints();
            }

            for (Point point : points) {
                Cluster closestCluster = null;
                double closestDistance = Double.MAX_VALUE;
                for (Cluster cluster : clusters) {
                    double distance = PointsUtils.calculateDistance(cluster.getCentroid(), point);
                    if (distance < closestDistance) {
                        closestDistance = distance;
                        closestCluster = cluster;
                    }
                }
                if (closestCluster != null) {
                    closestCluster.addPoint(point);
                }
            }

            convergence = true;
            for (Cluster cluster : clusters) {
                Point oldCentroid = new Point(cluster.getCentroid().getX(), cluster.getCentroid().getY());
                cluster.setCentroid(calculateCentroid(cluster));
                if (PointsUtils.calculateDistance(oldCentroid, cluster.getCentroid()) > 0.0001) {
                    convergence = false;
                }
            }
        }

        return clusters;
    }

    private static Point calculateCentroid(Cluster cluster) {
        double sumX = 0, sumY = 0;
        for (Point point : cluster.getPoints()) {
            sumX += point.getX();
            sumY += point.getY();
        }
        return new Point(sumX / cluster.getPoints().size(), sumY / cluster.getPoints().size());
    }

}
