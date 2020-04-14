package com.mutex.selenium.testdata;

public class SuivreVosSalariesInput {
	private SuivreVosSalariesInput(String siret, String contrat, String college, String... valueList) {
		this.siret = siret;
		this.contrat = contrat;
		this.college = college;
		this.valueList = valueList;
	}

	private String siret;
	private String contrat;
	private String college;
	private String[] valueList;

	public String getSiret() {
		return siret;
	}

	public String getContrat() {
		return contrat;
	}

	public String getcollege() {
		return college;
	}

	public String[] getvalueList() {
		return valueList;
	}

	public static SuivreVosSalariesInput nonDsn() {
		return new SuivreVosSalariesInput("69202823600028", "92584675", "Salariés ne relevant pas des Art.4 et 4 bis CCN 47", "JUMEAU STEPHANIE",
				"MAANANE MERYEM");
	}

	public static SuivreVosSalariesInput dsn() {
		return new SuivreVosSalariesInput("49426756000030", "107801352", "Salaries_Non_Cadre", "BACH LAURE",
				"CHAPLIN-BUSICO CHRISTELLE", "CID CLARA", "CLEYET-MERLE LISA", "DA COSTA JENNIFER", "DOMENE CLAIRE",
				"RYCKMANS DAMIEN");
	}

}
