package engine;


public class PokemonBattling extends Pokemon{
	

	private int mDef=0, mAtk=0, mSpdef=0, mSpatk=0, mSpd=0;
	private int acc=100, evs=100;

	
	private boolean confused=false;
	
	private boolean attracted=false;
	private boolean flinched=false;
	
	private boolean seeded=false;
	private boolean whirlpooled=false;
	private boolean fireSpined=false;
	private boolean sandTombed=false;
	private boolean wrapped=false;
	private boolean clamped=false;
	private boolean binded=false;
	private boolean cursed=false;
	
	private boolean encored=false;
	
	private boolean badlyPoisoned=false;


	public PokemonBattling(PokemonSpieces spieces) {
		super(spieces);
	}

	
	 public Pokemon turnIntoNotBattling()
	 {
		 Pokemon out=new Pokemon(spieces);
		 
		 out.atk=this.atk;
		 out.def=this.def;
		 out.hp=this.hp;
		 out.spatk=this.spatk;
		 out.spdef=this.spdef;
		 out.spd=this.spd;
		 out.maxhp=this.maxhp;
		 
		 out.ev_atk=this.ev_atk;
		 out.ev_hp=this.ev_hp;
		 out.ev_def=this.ev_def;
		 out.ev_spdef=this.ev_spdef;
		 out.ev_spatk=this.ev_spatk;
		 out.ev_spd=this.ev_spd;
		 
		 out.level=this.level;
		 out.status=this.status;
		 out.name=this.name;
		 
		 out.move[0]=this.move[0];
		 out.move[0]=this.move[1];
		 out.move[0]=this.move[2];
		 out.move[0]=this.move[3];
		 
		 out.iv_atk=this.iv_atk;
		 out.iv_hp=this.iv_hp;
		 out.iv_def=this.iv_def;
		 out.iv_spdef=this.iv_spdef;
		 out.iv_spatk=this.iv_spatk;
		 out.iv_spd=this.iv_spd;
				 	 
		 return out;
	 }
	
	double stat(int m) //m_staty - zmienione w trakcie walki
	{
		return (m>=0)? (m+2)/2 : 2/(-m+2); //prawidłowy mnożnik
	}
	
	public int resultAtk()
	{
		return atk*(int)stat(mAtk);
	}
	
	public int resultSpatk()
	{
		return spatk*(int)stat(mSpatk);
	}
	
	public int resultDef()
	{
		return def*(int)stat(mDef);
	}
	
	public int resultSpdef()
	{
		return spdef*(int)stat(mSpdef);
	}
	
	public int resultSpd()
	{
		return spd*(int)stat(mSpd);
	}
	
	public boolean modifyMAtk(int n)
	{
		if(mAtk<=-6)
		{
			return false;
		}
		else
		{
			mAtk-=n;
			return true;
		}
	}
	
	public boolean modifyMSpatk(int n)
	{
		if(mSpatk<=-6)
		{
			return false;
		}
		else
		{
			mSpatk-=n;
			return true;
		}
	}
	
	public boolean modifyMDef(int n)
	{
		if(mDef<=-6)
		{
			return false;
		}
		else
		{
			mDef-=n;
			return true;
		}
	}
	
	public boolean modifyMSpdef(int n)
	{
		if(mSpdef<=-6)
		{
			return false;
		}
		else
		{
			mSpdef-=n;
			return true;
		}
	}
	
	public boolean modifyMSpd(int n)
	{
		if(mSpd<=-6)
		{
			return false;
		}
		else
		{
			mSpd-=n;
			return true;
		}
	}

	public int getmDef() {
		return mDef;
	}

	public void setmDef(int mDef) {
		this.mDef = mDef;
	}

	public int getmAtk() {
		return mAtk;
	}

	public void setmAtk(int mAtk) {
		this.mAtk = mAtk;
	}

	public int getmSpdef() {
		return mSpdef;
	}

	public void setmSpdef(int mSpdef) {
		this.mSpdef = mSpdef;
	}

	public int getmSpatk() {
		return mSpatk;
	}

	public void setmSpatk(int mSpatk) {
		this.mSpatk = mSpatk;
	}

	public int getmSpd() {
		return mSpd;
	}

	public void setmSpd(int mSpd) {
		this.mSpd = mSpd;
	}

	public int getAcc() {
		return acc;
	}

	public void setAcc(int acc) {
		this.acc = acc;
	}

	public int getEvs() {
		return evs;
	}

	public void setEvs(int evs) {
		this.evs = evs;
	}

	public boolean isConfused() {
		return confused;
	}

	public void setConfused(boolean confused) {
		this.confused = confused;
	}

	public boolean isAttracted() {
		return attracted;
	}

	public void setAttracted(boolean attracted) {
		this.attracted = attracted;
	}

	public boolean isFlinched() {
		return flinched;
	}

	public void setFlinched(boolean flinched) {
		this.flinched = flinched;
	}

	public boolean isSeeded() {
		return seeded;
	}

	public void setSeeded(boolean seeded) {
		this.seeded = seeded;
	}

	public boolean isWhirlpooled() {
		return whirlpooled;
	}

	public void setWhirlpooled(boolean whirlpooled) {
		this.whirlpooled = whirlpooled;
	}

	public boolean isFireSpined() {
		return fireSpined;
	}

	public void setFireSpined(boolean fireSpined) {
		this.fireSpined = fireSpined;
	}

	public boolean isSandTombed() {
		return sandTombed;
	}

	public void setSandTombed(boolean sandTombed) {
		this.sandTombed = sandTombed;
	}

	public boolean isWrapped() {
		return wrapped;
	}

	public void setWrapped(boolean wrapped) {
		this.wrapped = wrapped;
	}

	public boolean isClamped() {
		return clamped;
	}

	public void setClamped(boolean clamped) {
		this.clamped = clamped;
	}

	public boolean isBinded() {
		return binded;
	}

	public void setBinded(boolean binded) {
		this.binded = binded;
	}

	public boolean isCursed() {
		return cursed;
	}

	public void setCursed(boolean cursed) {
		this.cursed = cursed;
	}

	public boolean isEncored() {
		return encored;
	}

	public void setEncored(boolean encored) {
		this.encored = encored;
	}

	
	
}
