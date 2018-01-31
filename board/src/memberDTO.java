
public class memberDTO {

	String mId;
	String mPw;
	String mName;
	String mAddress;
	String mEmail;
	
	public memberDTO() {
			
	}
	
	public memberDTO(String mId,String mPw,String mName,String mAddress,String mEmail) {
		this.mId = mId;
		this.mPw = mPw;
		this.mAddress = mAddress;
		this.mName = mName;
		this.mEmail = mEmail;			
	}

	public String getmId() {
		return mId;
	}
	public void setmId(String mId) {
		this.mId = mId;
	}
	public String getmPw() {
		return mPw;
	}
	public void setmPw(String mPw) {
		this.mPw = mPw;
	}
	public String getmName() {
		return mName;
	}
	public void setmName(String mName) {
		this.mName = mName;
	}
	public String getmAddress() {
		return mAddress;
	}
	public void setmAddress(String mAddress) {
		this.mAddress = mAddress;
	}
	public String getmEmail() {
		return mEmail;
	}
	public void setmEmail(String mEmail) {
		this.mEmail = mEmail;
	}
	
}
