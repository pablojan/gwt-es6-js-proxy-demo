
## Using ES6 proxies from GWT with JSInterop

### Example scenario

The demo provides a GWT-backed data API that mimics JavaScript object using ES6 proxies.
This approach can be follow to provide a JS view of data types synced and/or stored in GWT.

Note: functions and Objects are exposed in the namespace "swell".

```
	// Let's create an object backed by GWT code
	var gwto = swell.Object.create();
	
	// Populate some primitive values with chain syntax
	gwto.put("k0", "hello world").put("k1", 234).put("k2", 123.34);
	
	// Put a nested map
	gwto.put("k3", swell.Map.create().put("subk0","fun value"));
	
	// Also put JS objects ;)
	gwto.put("kjs", { prop : "value" });
	
	// get the object keys:
	gwto.keys();
	
	// Retriving values
	console.log(gwto.get("k2"));
	console.log(gwto.get("k1"));
	console.log(gwto.get("k0"));
	console.log(gwto.get("k3").get("subk0"));
	
	gwto.get("kjs");
	
	// wait!!!  better if we use it as native JS objects
	var jso = gwto.asNative();
	
	console.log(jso.k2);
	console.log(jso.k1);
	// ...

	jso.k4 = "New value";
	jso.k5 = swell.Map.create();

```

### Run

This projects uses Gradle:

Compile the GWT project
```
$> ./gradlew compileGwt
```

Run the web server
```
$> ./gradlew jettyGwt
```

Browse to [demo page](http://localhost:8080/gwt-es6-proxy)
Open developers console and test the previous example.


### Exploring the code

The class *Proxy* refers to the native JavaScript object using JSInterop



