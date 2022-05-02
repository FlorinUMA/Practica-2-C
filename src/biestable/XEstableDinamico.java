package biestable;

public class XEstableDinamico extends XEstable {
	public XEstableDinamico() {
		super.setMediador(new MediadorBiestable());
	}

	public void cambio() {
		super.setMediador((super.getMediador() instanceof MediadorBiestable) ? (new MediadorTriestable())
				: (new MediadorBiestable()));
		if (super.getColorEstable() instanceof ColorAmarillo) {
			super.setColorEstable(super.getMediador().cambioColor(super.getColorEstable(), false));
		}
	}

}
