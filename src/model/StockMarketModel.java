package model;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class StockMarketModel extends Observable{
	
	private ArrayList<Stock> stocks;
	private ArrayList<Observer> observers;
	private String currentstock;
	
	public StockMarketModel(){
		stocks = new ArrayList<Stock>();
		observers = new ArrayList<Observer>();
	}

	public void addObservers(Observer o){
		observers.add(o);
	}
	
	public ArrayList<Observer> getObservers(){
		return observers;
	}
	
	public void addStock(Stock s){
		stocks.add(s);
		if(stocks.size()==1){
			setCurrentStock(s.getName());
		}
		notifyView(this);
	}
	
	public String getCurrentStock(){
		return currentstock;
	}
	
	public void setCurrentStock(String name){
		currentstock = name;
		notifyView(this.getStock(name));
	}
	
	public Stock getStock(String StockName){
		for(int i=0 ; i<stocks.size() ; i++){
			if(stocks.get(i).getName().equals(StockName)){
				return stocks.get(i);
			}
		}
		return null;
	}
	
	public String[] getStocksNames(){
		String[] names = new String[stocks.size()];
		for(int i=0 ; i<stocks.size() ; i++){
			names[i] = stocks.get(i).getName();		
			}
		return names;
		}
	
	public int getSize(){
		return stocks.size();
	}
	
	public void notifyView(Observable o){
		for(int i=0 ; i<observers.size() ; i++){
			observers.get(i).update(o, null);
		}
	}
}
