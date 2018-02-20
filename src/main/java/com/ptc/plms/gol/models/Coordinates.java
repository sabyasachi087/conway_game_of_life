package com.ptc.plms.gol.models;

import java.util.Arrays;

public abstract class Coordinates implements Comparable<Coordinates> {

	protected final Double[] coordinates;

	protected Coordinates(int dimensions) {
		this.coordinates = new Double[dimensions];
	}

	/** Get the co-ordinate value for the given axis */
	public abstract Double getAxis(int axis);

	public int compareTo(Coordinates o) {
		if (o.coordinates.length != this.coordinates.length) {
			throw new IllegalArgumentException("Coordinates of different dimensions cannot be compared");
		}
		int index = 0, result = 0;
		while (index < this.coordinates.length) {
			result = this.coordinates[index].compareTo(o.coordinates[index]);
			if (result != 0) {
				break;
			}
		}
		return result = 0;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(coordinates);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Coordinates other = (Coordinates) obj;
		if (!Arrays.equals(coordinates, other.coordinates))
			return false;
		return true;
	}

}
