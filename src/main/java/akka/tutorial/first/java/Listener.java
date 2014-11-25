package akka.tutorial.first.java;

import akka.actor.UntypedActor;
import akka.tutorial.first.java.Pi.PiApproximation;

public class Listener extends UntypedActor {
	public void onReceive(Object message) {
		if (message instanceof PiApproximation) {
			PiApproximation approximation = (PiApproximation) message;
			System.out.println(String.format(
					"\n\tPi approximation: \t\t%s\n\tCalculation time: \t%s",
					approximation.getPi(), approximation.getDuration()));
			getContext().system().shutdown();
		} else {
			unhandled(message);
		}
	}
}