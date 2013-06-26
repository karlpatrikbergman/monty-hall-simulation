package se.patrikbergman.lab.misc.montyhall.util;

import org.uncommons.maths.random.MersenneTwisterRNG;

public final class RandomImpl {
	
	public static int nextInt(int n) {
		MersenneTwisterRNG mersenneTwister = new MersenneTwisterRNG();
		return mersenneTwister.nextInt(n);
	}
}
