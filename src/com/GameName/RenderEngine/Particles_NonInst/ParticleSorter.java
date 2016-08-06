package com.GameName.RenderEngine.Particles_NonInst;

import java.util.ArrayList;

public class ParticleSorter {

	 public static void sort(ArrayList<Particle> list) {
        for(int i = 1; i < list.size(); i++) {
            Particle particle = list.get(i);
            if (particle.getDistance() > list.get(i - 1).getDistance()) {
                sortUpHighToLow(list, i);
            }
        }
    }
 
    private static void sortUpHighToLow(ArrayList<Particle> list, int i) {
        Particle particle = list.get(i);
        int attemptPos = i - 1;
        while (attemptPos != 0 && list.get(attemptPos - 1).getDistance() < particle.getDistance()) {
            attemptPos--;
        }
        
        list.remove(i);
        list.add(attemptPos, particle);
    }
}
