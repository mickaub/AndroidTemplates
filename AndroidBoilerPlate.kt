//MainActivity:

setContent{
    AppTheme{
        Surface(
            modifier = Modifier.fillMaxSize() //,
            //color = colorScheme.background
        ){
            App()
        }
    }
}

@Composable
fun App() {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar()
        }
    )
    {it ->
        LazyColumn(contentPadding = it){
            items(exampleItems) {
                ListItem(
                    item = it,
                    modifier = Modifier.padding(8.dp)
                )
            }
        }
    }
}

@Composable
fun TopAppBar(modifier: Modifier = Modifier){
    CenterAlignedTopAppBar(
        title = {
            Row(verticalAlignment = Alignment.CenterVertically){
                Text(
                    text = "Heading",
                    style = MaterialTheme.typography.displayMedium
                )
            }
        },
        colors = TopAppBarDefaults.CenterAlignedTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary,
            //titleContentColor = MaterialTheme.colorScheme.tertiary
        )
        modifier = modifier
    )
}

@Composable
fun ListItem(item: Item, modifier: Modifier = Modifier){
    Card(modifier = modifier){
        Column(modifier = Modifier.background(color = seed)){
            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
            ){
                ItemIcon(item.imageResourceId)
                ItemInformation(item.name, item.other)
            }
        }
    }
}

@Composable
fun ItemIcon(
    @DrawableRes exampleIcon: Int,
    modifier: Modifier = Modifier
){
    Image(
        modifier = modifier
            .size(64.dp)
            .padding(8.dp)
            .clip(shape = CircleShape),
        contentScale = ContentScale.Crop,
        painter = painterResource(exampleIcon),
        contentDescription = null
    )
}

@Composable
fun ItemInformation(
    @StringRes itemName: Int,
    itemOther: Int,
    modifier: Modifier = Modifier
){
    Column(modifier = modifier) {
        Text(
            text = stringResource(itemName),
            style = MaterialTheme.typography.displayMedium,
            modifier = Modifier.padding(top = 8.dp)
        )
        Text(
            text = itemOther.toString(),
            style = MaterialTheme.typography.displaySmall
        )
    }
}

@Preview(showBackground = true)
@Composable
fun Preview(){
    AppTheme(darkTheme = false){
        App()
    }
}

//data class and list (in data folder)
data class ExampleItem(
    @DrawableRes val imageRes: Int,
    @StringRes val name: Int,
    val other: Int
)

val exampleItems = listOf( //add drawable and string
    Item(R.drawable.example1, R.string.FirstString, 1)
)