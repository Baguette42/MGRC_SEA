package fr.sigl.epita.imoe.minigrc.servlets.utils;

public class MailResult {

	/**
	 * Le nombre d'envois de mails échoués
	 */
	private int invalidEmailCount = 0;

	/**
	 * Le nombre de données manquantes pour remplacer les tags
	 */
	private int missingDataCount = 0;

	/**
	 * Le nombre de mails envoyés
	 */
	private int sentMailsCount = 0;
	
	public MailResult(int invalidEmailCount, int missingDataCount, int sentMailsCount){
		
		this.invalidEmailCount = invalidEmailCount;
		this.missingDataCount = missingDataCount;
		this.sentMailsCount = sentMailsCount;
	}

	public int getInvalidEmailCount() {
		return invalidEmailCount;
	}

	public void setInvalidEmailCount(int invalidEmailCount) {
		this.invalidEmailCount = invalidEmailCount;
	}

	public int getMissingDataCount() {
		return missingDataCount;
	}

	public void setMissingDataCount(int missingDataCount) {
		this.missingDataCount = missingDataCount;
	}

	public int getSentMailsCount() {
		return sentMailsCount;
	}

	public void setSentMailsCount(int sentMailsCount) {
		this.sentMailsCount = sentMailsCount;
	}
	
}
