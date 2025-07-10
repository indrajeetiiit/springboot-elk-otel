# Spring Boot + ELK Stack + OpenTelemetry Logging Example

This project demonstrates how to integrate a Spring Boot application with the ELK stack (Elasticsearch, Logstash, Kibana) and structured JSON logging via Logback. It also sets up OpenTelemetry-compatible logs with optional trace context.

---

## 📦 Project Structure

spring-boot-app-elk-otel/
├── docker-compose.yml
├── logstash/
│   └── pipeline/
│       └── logstash.conf
├── spring-boot-app/
│   ├── src/
│   │   └── main/
│   │       ├── java/
│   │       │   └── com/example/demo/
│   │       │       ├── DemoApplication.java
│   │       │       └── controller/OrderController.java
│   │       └── resources/
│   │           └── logback-spring.xml
│   └── pom.xml


---

## 🚀 Getting Started

### Prerequisites

- Docker & Docker Compose
- Java 17+
- Maven

---

### Start ELK Stack

From the project root:

```bash
docker-compose up -d


This starts:
	•	Elasticsearch (port 9200)
	•	Logstash (port 5000)
	•	Kibana (port 5601)

First-time startup may take 1–2 minutes.


Run Spring Boot App

From inside the spring-boot-app/ directory:

mvn spring-boot:run


Or package it:

mvn clean package
java -jar target/*.jar


Send a Test Request

Call the test POST endpoint:


curl -X POST http://localhost:8080/api/orders \
  -H "Content-Type: application/json" \
  -d '{"orderId": "ORD123", "product": "Laptop", "quantity": 2}'



View Logs in Kibana
	1.	Open Kibana: http://localhost:5601
	2.	Go to Discover
	3.	Create a Data View:
		Name: logstash-*
		Time field: @timestamp
	4.	Filter or search logs using fields like message, trace, service, etc.



	•	Spring Boot
		@RestController with sample POST /api/orders
		Structured logging with logback-spring.xml
	•	Logback
		Logs encoded in JSON with trace/span IDs (for OpenTelemetry compatibility)
	•	Logstash
		Listens on port 5000, parses JSON lines
		Sends logs to Elasticsearch
	•	Kibana
		Visualizes logs with structured fields
	•	Docker Compose
		Full ELK stack bootstrapped locally



(Optional Enhancements)
	•	Add OpenTelemetry auto-instrumentation agent for traces
	•	Integrate with Prometheus + Grafana for metrics
	•	Add Filebeat for file-based log shipping
