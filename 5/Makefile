HEADERS = pid.hpp
OBJECTS = main.o pid.o 

default: run 

%.o: %.cpp $(HEADERS)
	g++ -c $< -o $@

run: $(OBJECTS)
	g++ $(OBJECTS) -o $@

clean:
	rm -f $(OBJECTS)
	rm run
