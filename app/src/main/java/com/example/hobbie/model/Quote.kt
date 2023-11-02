package com.example.hobbie.model

data class Quote(
	val quote: List<QuoteItem>
)

data class QuoteItem(
	val q: String,
	val a: String,
	val h: String
)

