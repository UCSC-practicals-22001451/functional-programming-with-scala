# Read Scala file paths from files_to_compile.txt into an array
$scalaFiles = Get-Content -Path "files_to_compile.txt"

# Compile Scala files
scalac -d out $scalaFiles

# Check if compilation was successful
if ($LASTEXITCODE -eq 0) {
    Write-Host "Compilation successful."
    # Assuming App contains the main method to start the application
    Write-Host "Run: scala -cp out App {filename}."
}
else {
    Write-Host "Compilation failed."
}