autowire:根據某種策略自動為非字面量屬性賦值
autowire="byName|byType"
byName:通過屬性名和spring容器中bean的id進行比較，若一致則可直接賦值
byType:通過spring容器中bean的類型，為兼容性的屬性賦值
	   在使用byType的過程中，要求spring容器中只能有一個能為屬性賦值的bean
選用建議: 當設置autowire屬性，會作用於該bean中所有的非字面量屬性，因此誰都不用
