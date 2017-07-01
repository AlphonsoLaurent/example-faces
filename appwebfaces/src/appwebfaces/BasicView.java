package appwebfaces;
import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import model.Car;
import services.CarService;
import util.SessionUtils; 
@ManagedBean(name="basicView")
@SessionScoped
public class BasicView implements Serializable{
	private static final long serialVersionUID = 2770479400260623063L;
	public BasicView() {
		// TODO Auto-generated constructor stub
	}
 
	@Inject
	private CarService car;
	 
	private String usuarioLogueado;

	public Car[] getCars() { 
		System.out.println("Hola estamos en llamada del lista de carros...");
		int x = 0;
		List<Car> list = car.createCars(100);
		Car[] listCar = new Car[list.size()];
		for (Car car1 : list) {
			listCar[x] = car1;
			x++;
			System.out.println(car1.getRandomColor()+" "+car1.getRandomPrice());
		}
		return listCar;
	}
	 
	public String getUsuarioLogueado() {
		HttpSession session = SessionUtils.getSession();
		usuarioLogueado = (String) session.getAttribute("username");
		return usuarioLogueado;
	}
	public void setUsuarioLogueado(String usuarioLogueado) {
		this.usuarioLogueado = usuarioLogueado;
	} 
}
