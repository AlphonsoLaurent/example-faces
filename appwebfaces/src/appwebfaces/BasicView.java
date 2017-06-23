package appwebfaces;
import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import model.Car;
import services.CarService; 
@ManagedBean(name="basicView")
@ViewScoped
public class BasicView implements Serializable{
 
	private static final long serialVersionUID = 2770479400260623063L;

	private List<Car> cars;
     
	    @ManagedProperty("#{carService}")
	    private CarService service;
	 
	    @PostConstruct
	    public void init() {
	        cars = service.createCars(10);
	    }
	     
	    public List<Car> getCars() {
	        return cars;
	    }
	 
	    public void setService(CarService service) {
	        this.service = service;
	    }
}
