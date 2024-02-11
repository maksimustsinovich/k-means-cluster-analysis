package by.ustsinovich.kmeansclusteranalysis.controller;

import by.ustsinovich.kmeansclusteranalysis.model.Cluster;
import by.ustsinovich.kmeansclusteranalysis.model.Point;
import by.ustsinovich.kmeansclusteranalysis.utils.ClusteringUtils;
import by.ustsinovich.kmeansclusteranalysis.utils.PointsUtils;
import by.ustsinovich.kmeansclusteranalysis.view.MainView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.ScatterChart;
import javafx.scene.control.Button;
import javafx.scene.control.Spinner;

import java.util.List;

public class MainController {
    @FXML
    public Spinner<Integer> spnPointsNum;
    @FXML
    public Spinner<Integer> spnClustersNum;
    @FXML
    public Button btnClusterize;
    @FXML
    public ScatterChart<Double, Double> scPoints;
    @FXML
    public Spinner<Integer> spnMaxAbscissa;
    @FXML
    public Spinner<Integer> spnMaxOrdinate;

    @FXML
    public void onBtnClusterizeAction(ActionEvent event) {
        MainView view = new MainView(scPoints);

        int clustersNum = spnClustersNum.getValue();
        int pointsNum = spnPointsNum.getValue();

        int maxAbscissa = spnMaxAbscissa.getValue();
        int maxOrdinate = spnMaxOrdinate.getValue();

        List<Point> points = PointsUtils.initializePointsListByRandom(pointsNum, maxAbscissa, maxOrdinate);

        List<Cluster> clusters = ClusteringUtils.clusterizeByKMeans(clustersNum, points);

        view.updateChart(clusters);
    }
}