package wxk.bank.entity;
/**
 * 功能实体（菜单目录实体）
 * @author Administrator
 *
 */
public class Capacity implements Comparable<Capacity>{
	private int capacityid;				// 功能ID
	private String capacityname;		// 功能名称
	private int parentid;				// 上下级关系 
	private String url;					// 点击菜单后右面会加载的页面
	private String icon;				// 功能图标
	private int serialnum;				// 排序
	private int accordion;				// 是不是在左面显示为顶级菜单
	private int status;					// 是否禁用
	public Capacity() {
		super();
	}
	public int getCapacityid() {
		return capacityid;
	}
	public void setCapacityid(int capacityid) {
		this.capacityid = capacityid;
	}
	public String getCapacityname() {
		return capacityname;
	}
	public void setCapacityname(String capacityname) {
		this.capacityname = capacityname;
	}
	public int getParentid() {
		return parentid;
	}
	public void setParentid(int parentid) {
		this.parentid = parentid;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getIcon(){
		return icon;
	}
	public void setIcon(String icon){
		this.icon = icon;
	}
	public int getSerialnum() {
		return serialnum;
	}
	public void setSerialnum(int serialnum) {
		this.serialnum = serialnum;
	}
	public int getAccordion() {
		return accordion;
	}
	public void setAccordion(int accordion) {
		this.accordion = accordion;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		return "Capacity [capacityid=" + capacityid + ", capacityname=" + capacityname + ", parentid=" + parentid
				+ ", url=" + url + ", icon=" + icon + ", serialnum=" + serialnum + ", accordion=" + accordion
				+ ", status=" + status + "]";
	}
	@Override
	public int compareTo(Capacity o) {
		if(this.accordion > o.accordion){
			return 1;
		}else if(this.accordion < o.accordion){
			return -1;
		}else{
			if(this.serialnum > o.serialnum){
				return 1;
			}else if(this.serialnum < o.serialnum){
				return -1;
			}else{
				return this.url.compareTo(o.url);
			}
		}
	}
}
