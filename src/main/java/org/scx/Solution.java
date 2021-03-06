package org.scx;

import static java.lang.String.format;

import java.util.Objects;


/**
 * Container class to hold solutions to the problem.
 */
public class Solution {

    public double totalCost;
    public double negativeRevenue;
    public double avgLostSales;
    public double facBackupCost;
    public double invCarryCost;

    public BackupPolicy backupPolicy;

    public double[] supplierProd;
    public double[] plantProd;
    public double[] dcTransfer;

    public double[] wip;
    public double[] fgToDC;
    public double[] fgToCustomer;

    public double[] fgStock;
    public double[] lostSales;

    public double[] backupFGTransfer;
    public double[] backupWIPTransfer;

    public double[] backupSupplier;
    public double[] backupWIP;
    public double[] backupFG;
    public double[] backupPlant;
    public double[] backupDC;

    public BackupPoliciyData policyData;

    /**
     * Backup policy for each node
     */
    public static class BackupPolicy {

        private int backupWIPInventory;
        private int backupFGInventory;

        private int backupSupplier;
        private int backupPlant;
        private int backupDC;

        public BackupPolicy(int backupSupplier, int backupWIP, int backupPlant, int backupFG, int backupDC) {
            this.backupSupplier = backupSupplier;
            this.backupWIPInventory = backupWIP;
            this.backupPlant = backupPlant;
            this.backupFGInventory = backupFG;
            this.backupDC = backupDC;
        }

        public int getBackupSupplier() {
            return backupSupplier;
        }

        public int getBackupWIP() {
            return backupWIPInventory;
        }

        public int getBackupPlant() {
            return backupPlant;
        }

        public int getBackupFG() {
            return backupFGInventory;
        }

        public int getBackupDC() {
            return backupDC;
        }

        @Override
        public int hashCode() {
            return Objects.hash(backupDC, backupFGInventory, backupPlant, backupSupplier, backupWIPInventory);
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            BackupPolicy other = (BackupPolicy) obj;
            return backupDC == other.backupDC
                    && backupFGInventory == other.backupFGInventory
                    && backupWIPInventory == other.backupWIPInventory
                    && backupSupplier == other.backupSupplier
                    && backupPlant == other.backupPlant;
        }


        @Override
        public String toString() {
            return "[" + backupWIPInventory + ", "
                    + backupFGInventory + ", "
                    + backupSupplier + ", "
                    + backupPlant + ", "
                    + backupDC + "]";
        }
    }

    public static class BackupPoliciyData {

        public final double backupFGPolicy;
        public final double backupWIPPolicy;
        public final double backupSupplierCapacity;
        public final double backupPlantCapacity;
        public final double backupDCCapacity;

        public final double[] backupSupplierDelayedCapacity;
        public final double[] backupPlantDelayedCapacity;
        public final double[] backupDCDelayedCapacity;

        public BackupPoliciyData(double backupFGPolicy, double backupWIPPolicy, double backupSupplierCapacity, double backupPlantCapacity,
                double backupDCCapacity, double[] backupSupplierDelayedCapacity, double[] backupPlantDelayedCapacity,
                double[] backupDCDelayedCapacity) {
            this.backupFGPolicy = backupFGPolicy;
            this.backupWIPPolicy = backupWIPPolicy;
            this.backupSupplierCapacity = backupSupplierCapacity;
            this.backupPlantCapacity = backupPlantCapacity;
            this.backupDCCapacity = backupDCCapacity;
            this.backupSupplierDelayedCapacity = backupSupplierDelayedCapacity;
            this.backupPlantDelayedCapacity = backupPlantDelayedCapacity;
            this.backupDCDelayedCapacity = backupDCDelayedCapacity;
        }

    }


    @Override
    public String toString() {
        return "Solution [totalCost=" + totalCost + ", avgLostSales=" + avgLostSales + ", facBackupCost=" + facBackupCost
                + ", invCarryCost=" + invCarryCost + ", backupPolicy=" + backupPolicy + "]";
    }

    /**
     * Display solution
     * 
     * @param s
     */
    public static void display(Solution s) {
        System.out.println("***\nThe unified model's solution has total cost "
                + String.format("%10.5f", s.totalCost)
                + ".\nInventory Cost: " + s.invCarryCost
                + ".\nBackup Cost: " + s.facBackupCost
                + ".\nLost Sales Cost: " + s.avgLostSales);
        System.out
                .println("WEEK  SupplierProd backupSupplier  backupWIPTransfer  wip  plantProd  backupPlant  fgToDC  fgStock  dcTransfer  backupFGTransfer  backupDC  fgToCustomer  LostSales");
        for (int i = 0; i < Data.WEEKS_PER_YEAR; i++) {
            System.out.print(i);
            System.out.print(" \t" + format("%.2f", s.supplierProd[i]));
            System.out.print(" \t" + format("%.2f", s.backupSupplier[i]));
            System.out.print(" \t" + format("%.2f", s.backupWIPTransfer[i]));
            System.out.print(" \t" + format("%.2f", s.wip[i]));
            System.out.print(" \t" + format("%.2f", s.plantProd[i]));
            System.out.print(" \t" + format("%.2f", s.backupPlant[i]));
            System.out.print(" \t" + format("%.2f", s.fgToDC[i]));
            System.out.print(" \t" + format("%.2f", s.fgStock[i]));
            System.out.print(" \t" + format("%.2f", s.dcTransfer[i]));
            System.out.print(" \t" + format("%.2f", s.backupFGTransfer[i]));
            System.out.print(" \t" + format("%.2f", s.backupDC[i]));
            System.out.print(" \t" + format("%.2f", s.fgToCustomer[i]));
            System.out.print(" \t" + format("%.2f", s.lostSales[i]));
            System.out.println();
        }
        System.out.println("BackUpPolicy : " + s.backupPolicy);
    }
}
