/**
 * WordGram objects represent a k-gram of strings/words.
 * 
 * @author YOUR-NAME
 *
 */

public class WordGram {
	
	private String[] myWords;   
	private String myToString;  // cached string
	private int myHash;         // cached hash value

	/**
	 * Create WordGram (add comments)
	 * @param source
	 * @param start
	 * @param size
	 */
	public WordGram(String[] source, int start, int size) {
		myWords = new String[size];
		for(int i=start; i<start+size; i++) {
			myWords[i-start] = source[i];
		}
		myToString = String.join(" ", myWords);
		myHash = myToString.hashCode();
		
		
	}

	/**
	 * Return string at specific index in this WordGram
	 * @param index in range [0..length() ) for string 
	 * @return string at index
	 */
	public String wordAt(int index) {
		if (index < 0 || index >= myWords.length) {
			throw new IndexOutOfBoundsException("bad index in wordAt "+index);
		}
		return myWords[index];
	}

	/**
	 * Complete this comment
	 * @return
	 */
	public int length(){
		// TODO: change this
		
		return myWords.length;
	}


	@Override
	public boolean equals(Object o) {
		if (! (o instanceof WordGram) || o == null){
			return false;
		}
		WordGram wg = (WordGram) o;
		
		if(this.length() != wg.length()) {
			return false;
		}
		
		for(int i=0; i<length(); i++) {
			if(!this.wordAt(i).equals(wg.wordAt(i))) {
				return false;
			}
			
		}

	    // TODO: complete this method
		return true;
	}

	@Override
	public int hashCode(){
		// TODO: complete this method
		return myHash;
	}
	

	/**
	 * Create and complete this comment
	 * @param last is last String of returned WordGram
	 * @return
	 */
	public WordGram shiftAdd(String last) {
		WordGram wg = new WordGram(myWords,0,myWords.length);
		// TODO: Complete this method
		for(int i=0; i<length()-1; i++) {
			wg.myWords[i] = wg.myWords[i+1];
		}
		wg.myWords[length()-1] = last;
		wg.myToString = String.join(" ", wg.myWords);
		wg.myHash = wg.myToString.hashCode();
		return wg;
	}

	@Override
	public String toString(){
		// TODO: Complete this method
		return myToString;
	}
}
