// License: GPL. For details, see Readme.txt file.
package org.openstreetmap.gui.jmapviewer;

import java.awt.geom.Point2D;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Objects;

import org.openstreetmap.gui.jmapviewer.interfaces.IProjected;

/**
 * Projected coordinates represented by an encapsulates a Point2D.Double value.
 */
public class Projected implements IProjected {
    private transient Point2D.Double data;

    /**
     * Constructs a new {@code Projected}.
     * @param east easting
     * @param north northing
     */
    public Projected(double east, double north) {
        data = new Point2D.Double(east, north);
    }

    
    public double getEast() {
        return data.x;
    }

    
    public double getNorth() {
        return data.y;
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.writeObject(data.x);
        out.writeObject(data.y);
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        data = new Point2D.Double();
        data.x = (Double) in.readObject();
        data.y = (Double) in.readObject();
    }

    
    public String toString() {
        return "Projected[" + data.y + ", " + data.x + ']';
    }

    
    public int hashCode() {
        int hash = 3;
        hash = 61 * hash + Objects.hashCode(this.data);
        return hash;
    }

    
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Projected other = (Projected) obj;
        return Objects.equals(this.data, other.data);
    }
}

