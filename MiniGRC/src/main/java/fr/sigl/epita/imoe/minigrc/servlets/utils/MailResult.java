package fr.sigl.epita.imoe.minigrc.servlets.utils;

public class MailResult {

	private int invalidEmailCount = 0;
	private int missingDataCount = 0;
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
