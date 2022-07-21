public abstract class Component {
	public abstract String describe();
	
	public void add(Component component){
	throw new UnsupportedOperationException("Current operation is not 					support - for this object");
	}
	public void remove(Component component){
	throw new UnsupportedOperationException("Current operation is not 					support - for this object");
	}
	public List<Component>getChildren(){
	throw new UnsupportedOperationException("Current operation is not 					support - for this object");
	}
}

public class SinglePart extends Component {
	private String componentName;
	
	public SinglePart(String componentName){
		this.componentName = componentName;
	}
	
	@Override
	public String describe() {
		return componentName+"\n";
	}
}

public class CompoundPart extends Component {
	private String componentName;
	private List<Component> childrenComponents;
	
	public CompoundPart(String componentName){
		this.componentName = componentName;
		this.childrenComponents = new ArrayList<>();
	}
	@Override
	public String describe() {
		String description=componentName+"\n\t";
		for(Component component: childrenComponents){
			description += component.describe();
		}
		return description;
	}
	@Override
	public void add(Component component){
		childrenComponents.add(component);
	}
	@Override
	public void remove(Component component){
		childrenComponents.remove(component);
	}
	@Override
	public List<Component> getChildren(){
		return childrenComponents;
	}
}

public class TestCompositePattern {
	public static void main(String[] args) {
		Component work_station = new CompoundPart("xtreme3000");
		Component piece1 = new CompoundPart("wildraccoon2.0");
		work_station.add(piece1);
		Component int_device = new SinglePart("corsair1kw");
		piece1.add(int_device);
		int_device = new SinglePart("mouse_g500");
		work_station.addChildTag(int_device);
		
		work_station.describe();
	}
}
