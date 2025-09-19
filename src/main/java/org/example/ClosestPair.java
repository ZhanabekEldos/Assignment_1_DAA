package org.example;

import java.util.Arrays;
import java.util.Comparator;

public class ClosestPair {

    public static double findClosestPair(Point[] points) {
        if (points == null || points.length < 2) {
            throw new IllegalArgumentException("At least two points are required");
        }

        Point[] sortedByX = points.clone();
        Arrays.sort(sortedByX, Comparator.comparingDouble(p -> p.x));

        Point[] aux = new Point[points.length];
        return closest(sortedByX, aux, 0, points.length - 1);
    }

    private static double closest(Point[] points, Point[] aux, int left, int right) {
        if (right - left <= 3) {
            return bruteForce(points, left, right);
        }

        int mid = (left + right) / 2;
        double midX = points[mid].x;

        double d1 = closest(points, aux, left, mid);
        double d2 = closest(points, aux, mid + 1, right);
        double d = Math.min(d1, d2);

        mergeByY(points, aux, left, mid, right);

        int stripSize = 0;
        for (int i = left; i <= right; i++) {
            if (Math.abs(points[i].x - midX) < d) {
                aux[stripSize++] = points[i];
            }
        }

        for (int i = 0; i < stripSize; i++) {
            for (int j = i + 1; j < stripSize && (aux[j].y - aux[i].y) < d; j++) {
                d = Math.min(d, dist(aux[i], aux[j]));
            }
        }

        return d;
    }

    private static void mergeByY(Point[] points, Point[] aux, int left, int mid, int right) {
        int i = left, j = mid + 1, k = left;
        while (i <= mid && j <= right) {
            if (points[i].y <= points[j].y) {
                aux[k++] = points[i++];
            } else {
                aux[k++] = points[j++];
            }
        }
        while (i <= mid) aux[k++] = points[i++];
        while (j <= right) aux[k++] = points[j++];
        for (int t = left; t <= right; t++) {
            points[t] = aux[t];
        }
    }

    private static double bruteForce(Point[] points, int left, int right) {
        double minDist = Double.POSITIVE_INFINITY;
        for (int i = left; i <= right; i++) {
            for (int j = i + 1; j <= right; j++) {
                minDist = Math.min(minDist, dist(points[i], points[j]));
            }
        }
        return minDist;
    }

    private static double dist(Point a, Point b) {
        double dx = a.x - b.x;
        double dy = a.y - b.y;
        return Math.sqrt(dx * dx + dy * dy);
    }

    public static class Point {
        public final double x, y;
        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }
}

