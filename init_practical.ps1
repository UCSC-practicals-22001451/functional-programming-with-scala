# Define the input file path
$inputFilePath = "init_practical_info.txt"

# Read the content of the input file
$content = Get-Content -Path $inputFilePath

# Extract the number from the first line
$number = $content[0]

# Extract the names from the subsequent lines
$names = $content[1..($content.Length - 1)]

# Create the main folder
$mainFolder = "practical_$number"
New-Item -ItemType Directory -Path $mainFolder

# Loop through each name and create the corresponding file
foreach ($name in $names) {
  # Define the file path
  $filePath = "$mainFolder\$name.scala"
    
  # Define the content of the file
  $fileContent = @"
package practical_$number
object $name {
  def run(): Unit = {
  }
}
"@
    
  # Create the file and write the content
  Set-Content -Path $filePath -Value $fileContent
}

# Define the path to App.scala
$appFilePath = "App.scala"

# Read the content of App.scala
$appContent = Get-Content -Path $appFilePath

# Comment out the previous cases that are not already commented
$appContent = $appContent -replace '(?<!// )(case "p\d+e\d+" => .+\.run\(\))', '//$1'

# Add new entries for each newly created file
$newCases = ""
for ($i = 0; $i -lt $names.Length; $i++) {
  $newCases += '        case "p' + $number + 'e' + ($i + 1) + '" => practical_' + $number + '.' + $names[$i] + '.run()`n'
}

# Insert the new cases before the default case
$appContent = $appContent -replace '(case _\s+=>\s+println\("Exercise not found."\))', "$newCases$1"

# Write the updated content back to App.scala
Set-Content -Path $appFilePath -Value $appContent