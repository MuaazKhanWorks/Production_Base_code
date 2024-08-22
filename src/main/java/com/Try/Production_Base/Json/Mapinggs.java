package com.Try.Production_Base.Json;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
public class Mapinggs {
     final String json = """
     {
	"jobName": "79a9048c-ee36-432a-93c8-bfeb082e2995",
	"accountId": "024848438458",
	"status": "COMPLETED",
	"results": {
		"transcripts": [
			{
				"transcript": "Hello there."
			}
		],
		"items": [
			{
				"id": 0,
				"type": "pronunciation",
				"alternatives": [
					{
						"confidence": "0.998",
						"content": "Hello"
					}
				],
				"start_time": "0.009",
				"end_time": "0.49"
			},
			{
				"id": 1,
				"type": "pronunciation",
				"alternatives": [
					{
						"confidence": "0.999",
						"content": "there"
					}
				],
				"start_time": "0.5",
				"end_time": "0.79"
			},
			{
				"id": 2,
				"type": "punctuation",
				"alternatives": [
					{
						"confidence": "0.0",
						"content": "."
					}
				]
			}
		],
		"audio_segments": [
			{
				"id": 0,
				"transcript": "Hello there.",
				"start_time": "0.0",
				"end_time": "0.92",
				"items": [
					0,
					1,
					2
				]
			}
		]
	}
}
""";
}
