package es.deusto.ingeniaria.sd.strava.gateway;

import es.deusto.ingenieria.sd.strava.server.data.dto.TipoProveedor;

public class Factory {
	private static Factory factory;
	
	private Factory() {
		
	}
	
	public static Factory getInstance() {
		if(factory == null) {
			factory = new Factory();
		}
		return factory;
	}
	
	public IGateWay createGateWay(TipoProveedor t) {
		if(t.equals(TipoProveedor.GOOGLE)) {
			return GateWayGoogle.getGateWay();
		}else if(t.equals(TipoProveedor.FACEBOOK)){
			return GateWayFacebook.getGateWay();
		}else {
			return null;
		}
	}
}
