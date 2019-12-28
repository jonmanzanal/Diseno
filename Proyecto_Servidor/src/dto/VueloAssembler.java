package dto;


import data.Vuelo;

public class VueloAssembler {
	private static VueloAssembler instance;

	private VueloAssembler() { }
	
	public static VueloAssembler getInstance() {
		if (instance == null) {
			instance = new VueloAssembler();
		}

		return instance;
	}

	public VueloDTO entityToDTO(Vuelo vuelo) {
		VueloDTO dto = new VueloDTO();
		
		dto.setIdvu(vuelo.getId_vu());
		
		
		
				
		return dto;
	}
}
