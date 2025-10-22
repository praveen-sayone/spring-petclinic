#!/bin/bash
SUMMARY=$(git log --since="3 months ago" --pretty=format:"%h - %s")
espeak -w commit-history.wav "$SUMMARY"
