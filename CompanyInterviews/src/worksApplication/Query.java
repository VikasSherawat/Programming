package worksApplication;

public class Query {
int query;
int city;
public Query(int query,int city){
	this.query = query;
	this.city = city;
}

public int getQuery(){
	return this.query;
}

public int getCity(){
	return this.city;
}
}
